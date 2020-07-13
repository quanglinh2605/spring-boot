package apis;

import java.util.List;

import entities.Student;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StudentAPI {
	
	@GET("student/findbymonth/{month}")
	Call<List<Student>> findbymonth(@Path("month") int month);
	
	@GET("student/findbyid/{id}")
	Call<ResponseBody> xeploai(@Path("id") int id);
	
	@GET("student/bestScore/{n}")
	Call<List<Student>> bestScore(@Path("n") int n);
}
