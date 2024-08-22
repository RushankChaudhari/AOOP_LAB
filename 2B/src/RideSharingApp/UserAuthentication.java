package RideSharingApp;

public class UserAuthentication {
    private static UserAuthentication instance;
    private boolean isAuthenticated;

    private UserAuthentication() {
        isAuthenticated = false;
    }

    public static UserAuthentication getInstance() {
        if (instance == null) {
            instance = new UserAuthentication();
        }
        return instance;
    }

    public void login() {
        isAuthenticated = true;
    }

    public void logout() {
        isAuthenticated = false;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }
}

