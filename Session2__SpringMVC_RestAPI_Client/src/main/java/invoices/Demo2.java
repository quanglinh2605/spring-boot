package invoices;

import java.text.SimpleDateFormat;
import java.util.List;

import apis.APIClient;
import apis.InvoiceAPI;
import entities.Invoice;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Demo2 {
	public static void main(String[] args) {
		try {
			InvoiceAPI invoiceAPI = APIClient.getClient().create(InvoiceAPI.class);
			invoiceAPI.find("Cash", 11, 19).enqueue(new Callback<List<Invoice>>() {
				
		
				public void onResponse(Call<List<Invoice>> call, Response<List<Invoice>> response) {
					try {
						if(response.isSuccessful()) {
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							List<Invoice> invoices = response.body();
							System.out.println("List Invoice");
							for (Invoice invoice : invoices) {
								System.out.println("Id: " + invoice.getId());
								System.out.println("Name: " + invoice.getName());
								System.out.println("Payment: " + invoice.getPayment());
								System.out.println("Total: " + invoice.getTotal());
								System.out.println("Created: " + dateFormat.format(invoice.getCreated()));
								System.out.println("------------------------------");
							}
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
		
				public void onFailure(Call<List<Invoice>> call, Throwable t) {
					System.out.println(t.getMessage());
				}
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}