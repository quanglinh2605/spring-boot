package demo;

import java.util.List;

import apis.APIClient;
import apis.ProductAPI;
import entities.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Demo1 {
	public static void main(String[] args) {
		try {
			ProductAPI productAPI = APIClient.getClient().create(ProductAPI.class);
			productAPI.findAll().enqueue(new Callback<List<Product>>() {

				public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
					try {
						if (response.isSuccessful()) {
							List<Product> products  = response.body();
							System.out.println(products.size());
							System.out.println("Product List");
							for(Product product : products) {
								System.out.println("id: " + product.getId());
								System.out.println("Name: " + product.getName());
								System.out.println("Price: " + product.getPrice());
								System.out.println("------------------------");
							}
						}
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}

				public void onFailure(Call<List<Product>> call, Throwable t) {
					System.err.println(t.getMessage());
				}
			});
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
