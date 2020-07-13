package apis;

import java.util.List;

import entities.Product;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProductAPI {
	
	@GET("product/findAll")
	Call<List<Product>> findAll();
	
	@GET("product/find/{id}")
	Call<Product> find(@Path("id") int id);
	
	@GET("product/findbyname/{keyword}")
	Call<List<Product>> search(@Path("keyword") String Keyword); 
	
	@GET("product/findbyprice/{min}/{max}")
	Call<List<Product>> search(@Path("min") double min, @Path("max") double max);
	
	@POST("product/create")
	Call<Product> create(@Body Product product);
	
	@PUT("product/update")
	Call<Product> update(@Body Product product);
	
	@DELETE("product/delete/{id}")
	Call<Void> delete(@Path("id") int id);
	
	@GET("product/total/{id}")
	Call<Double> total(@Path("id") int id);
}
