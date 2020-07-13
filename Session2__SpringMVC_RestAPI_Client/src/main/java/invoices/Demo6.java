package invoices;


import apis.APIClient;
import apis.InvoiceAPI;
import entities.Invoice;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Demo6 {
	public static void main(String[] args) {
		try {
			Invoice invoice = new Invoice(4,"Invoice 4","Visa Card",8,"2018-05-26");
			
			InvoiceAPI invoiceAPI = APIClient.getClient().create(InvoiceAPI.class);
			invoiceAPI.update(invoice).enqueue(new Callback<Invoice>() { 

				public void onResponse(Call<Invoice> call, Response<Invoice> response) {
					try {
						System.out.println("Status code: " + response.code());
						System.out.println("isSuccessful: " + response.isSuccessful());
						if (response.isSuccessful()) {
							Invoice invoice  = response.body();
							System.out.println("Invoice Info");
							
								System.out.println("id: " + invoice.getId());
								System.out.println("Name: " + invoice.getName());
								System.out.println("Payment: " + invoice.getPayment());
								System.out.println("Total: " + invoice.getTotal());
								System.out.println("------------------------");
							}
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}

				public void onFailure(Call<Invoice> call, Throwable t) {
					System.err.println(t.getMessage());
				}
			});
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
