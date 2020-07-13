package invoices;

import apis.APIClient;
import apis.InvoiceAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Demo4 {
	public static void main(String[] args) {
		try {
			
			InvoiceAPI invoiceAPI = APIClient.getClient().create(InvoiceAPI.class);
			invoiceAPI.total("Cash").enqueue(new Callback<Double>() {

				public void onResponse(Call<Double> call, Response<Double> response) {
					try {
						if(response.isSuccessful()) {
							System.out.println("Status code: " + response.code());
							System.out.println("isSuccessful: " + response.isSuccessful());
							double total = response.body();
							System.out.println("total: " + total);
						}
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}

				public void onFailure(Call<Double> call, Throwable t) {
					System.err.println(t.getMessage());
				}
			});
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
