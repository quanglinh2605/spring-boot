package demo;

import apis.APIClient;
import apis.ProductAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Demo7 {
	public static void main(String[] args) {
		try {
			
			ProductAPI productAPI = APIClient.getClient().create(ProductAPI.class);
			productAPI.delete(4).enqueue(new Callback<Void>() {

				public void onResponse(Call<Void> call, Response<Void> response) {
					try {
						System.out.println("Status code: " + response.code());
						System.out.println("isSuccessful: " + response.isSuccessful());
						
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}

				public void onFailure(Call<Void> call, Throwable t) {
					System.err.println(t.getMessage());
				}
			});
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
