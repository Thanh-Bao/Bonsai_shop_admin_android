package com.nonglam.baobaoshopadmin.data;

import android.util.Log;

import com.nonglam.baobaoshopadmin.API.APIServices;
import com.nonglam.baobaoshopadmin.MainActivity;
import com.nonglam.baobaoshopadmin.data.model.LoggedInUser;
import com.nonglam.baobaoshopadmin.model.User;

import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    private LoggedInUser fakeUser ;

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication



        APIServices.apiServices.login(new User("admin","Admin123@#"))
        .enqueue(new
                         Callback<User>() {
                             @Override
                             public void onResponse(Call<User> call, Response<User> response) {
                                 User user = response.body();

                                  fakeUser =
                                         new LoggedInUser(
                                                 java.util.UUID.randomUUID().toString(),
                                                 user.getToken());
                                MainActivity.sqLite.queryData("INSERT INTO TOKEN VALUES(\""+user.getToken()+"\")");


                             }

                             @Override
                             public void onFailure(Call<User> call, Throwable t) {
                                 Log.d("MYTAG123", "LOIIIII");
                             }
                         }
        );

            if(fakeUser!=null){
                return new Result.Success<>(fakeUser);
            }
            return new Result.Error(new IOException("Sai tài khoản, mật khẩu, vui lòng kiểm tra lại"));
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}