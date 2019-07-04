package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.business.OrderProcessingServiceBean;
import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.*;
import edu.osu.cse5234.util.ServiceLocator;

@Controller
@RequestMapping("/purchase")
public class Purchase {

	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Inventory inventory = ServiceLocator.getInventoryService().getAvailableInventory();

		Map<Integer, Item> map = inventory.getMap();
		List<LineItem> lineItems = new ArrayList<>();

		// Item --> LineItem
		for (Map.Entry<Integer, Item> entry: map.entrySet()) {
			Item item = entry.getValue();
			lineItems.add(new LineItem(item.getId(), 0, item.getName(), item.getUnitPrice()));
		}

		Order order = new Order();
		order.setLineItems(lineItems);

		request.setAttribute("order", order);

		return "OrderEntryForm";
	}

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		// remove lineItems that have 0 quantity
		List<LineItem> lineItems = order.getLineItems();
		Iterator<LineItem> itr = lineItems.iterator();
        while (itr.hasNext()) {
            LineItem x = itr.next();
            if (x.getQuantity() == 0) itr.remove();
        }

		boolean orderValid = ServiceLocator.getOrderProcessingService().validateItemAvailability(order);
		if(orderValid) {
			request.getSession().setAttribute("order", order);
			return "redirect:/purchase/paymentEntry";
		} else {
			System.out.println("Please Resubmit the item quantities");
			return "redirect:/purchase/OrderEntryForm";
		}
	}

	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryForm(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("paymentInfo", new PaymentInfo());	
		return "PaymentEntryForm";
	}

	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("paymentInfo") PaymentInfo paymentInfo, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("paymentInfo", paymentInfo);
		return "redirect:/purchase/shippingEntry";
	}

	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String viewShippingEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("shippingInfo", new ShippingInfo());
		return "ShippingEntryForm";
	}

	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("shippingInfo", shippingInfo);
		return "redirect:/purchase/viewOrder";
	}

	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrderPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "ViewOrder";
	}

	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(HttpServletRequest request) {
		Order order = (Order)request.getSession().getAttribute("order");

		ShippingInfo shippingInfo = (ShippingInfo) request.getSession().getAttribute("shippingInfo");
		PaymentInfo paymentInfo = (PaymentInfo) request.getSession().getAttribute("paymentInfo");

		order.setPayment(paymentInfo);
		order.setShipping(shippingInfo);

		OrderProcessingServiceBean orderProcessingService = ServiceLocator.getOrderProcessingService();
		String confirmNumb = orderProcessingService.processOrder(order);
		request.getSession().setAttribute("confirmationNum", confirmNumb);
		return "redirect:/purchase/confirmation";
	}

	@RequestMapping(path = "/confirmation", method = RequestMethod.GET)
	public String viewConfirmationPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "Confirmation";
	}
}
