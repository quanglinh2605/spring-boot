package student;

import java.util.List;

import apis.APIClient;
import apis.StudentAPI;
import entities.Student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Demo1 {
	public static void main(String[] args) {
		try {
			StudentAPI studentAPI = APIClient.getClient().create(StudentAPI.class);
			studentAPI.findbymonth(04).enqueue( new Callback<List<Student>>() {

				public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
					try {
						if(response.isSuccessful()) {
							System.out.println("status code " + response.code());
							System.out.println("isSuccesfull " + response.isSuccessful());
							List<Student> students = response.body();
							System.out.println("Student List");
							for (Student student : students) {
								System.out.println("id: " + student.getId());
								System.out.println("name: " + student.getName());
								System.out.println("score: " + student.getScore());
								System.out.println("birthday: " + student.getBirthday());
								System.out.println("------------------------------");
							}
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				public void onFailure(Call<List<Student>> call, Throwable t) {
					System.out.println(t.getMessage());
					
				}
				
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
