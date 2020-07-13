package apis;

import java.util.List;

import entities.Invoice;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface InvoiceAPI {
	@GET("invoice/newInvoice/{n}")
	Call<List<Invoice>> newInvoices(@Path("n") int n);
	
	@GET("invoice/find/{payment}/{min}/{max}")
	Call<List<Invoice>> find(@Path("payment") String payment, @Path("min") double min, @Path("max") double max);
	
	@GET("invoice/count/{m}/{y}")
	Call<Integer> search(@Path("m") int m, @Path("y") int y);
	
	@GET("invoice/total/{payment}")
	Call<Double> total(@Path("payment") String payment);
	
	@PUT("invoice/update")
	Call<Invoice> update(@Body Invoice invoice);
}
