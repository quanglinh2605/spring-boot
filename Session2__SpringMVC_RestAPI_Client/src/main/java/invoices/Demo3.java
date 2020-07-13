package invoices;


import apis.APIClient;
import apis.InvoiceAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Demo3 {
	public static void main(String[] args) {
		try {
			InvoiceAPI invoiceAPI = APIClient.getClient().create(InvoiceAPI.class);
			invoiceAPI.search(5, 2018).enqueue(new Callback<Integer>() {
			
				public void onResponse(Call<Integer> call, Response<Integer> response) {
					try {
						if(response.isSuccessful()) {
							int result = response.body();
							System.out.println("So hoa don la:" + result);
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
				public void onFailure(Call<Integer> call, Throwable t) {
					System.out.println(t.getMessage());
				}
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}