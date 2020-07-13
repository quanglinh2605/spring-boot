package student;


import apis.APIClient;
import apis.StudentAPI;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Demo2 {
	public static void main(String[] args) {
		try {
			StudentAPI studentAPI = APIClient.getClient().create(StudentAPI.class);
			studentAPI.xeploai(4).enqueue( new Callback<ResponseBody>() {

				public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
					try {
						if(response.isSuccessful()) {
							System.out.println("status code " + response.code());
							System.out.println("isSuccesfull " + response.isSuccessful());
							String xeploai = response.body().string();
							System.out.println("xep loai: " + xeploai);
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}				public void onFailure(Call<ResponseBody> call, Throwable t) {
					System.out.println(t.getMessage());
				}
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
