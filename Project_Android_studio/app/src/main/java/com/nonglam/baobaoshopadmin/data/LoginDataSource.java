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