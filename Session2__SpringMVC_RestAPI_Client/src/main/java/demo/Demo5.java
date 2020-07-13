package demo;

import apis.APIClient;
import apis.ProductAPI;
import entities.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Demo5 {
	public static void main(String[] args) {
		try {
			Product product = new Product();
			product.setName("ABC");
			product.setPrice(4.5);
			product.setQuantity(6);
			product.setStatus(true);
			product.setDescription("DEF");
			
			ProductAPI productAPI = APIClient.getClient().create(ProductAPI.class);
			productAPI.create(product).enqueue(new Callback<Product>() {

				public void onResponse(Call<Product> call, Response<Product> response) {
					try {
						System.out.println("Status code: " + response.code());
						System.out.println("isSuccessful: " + response.isSuccessful());
						if (response.isSuccessful()) {
							Product product  = response.body();
							System.out.println("Product Info");
							
								System.out.println("id: " + product.getId());
								System.out.println("Name: " + product.getName());
								System.out.println("Price: " + product.getPrice());
								System.out.println("------------------------");
							}
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}

				public void onFailure(Call<Product> call, Throwable t) {
					System.err.println(t.getMessage());
				}
			});
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
