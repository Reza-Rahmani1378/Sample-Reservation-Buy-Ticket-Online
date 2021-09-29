package ir.maktab56.airline.util;


import ir.maktab56.airline.domain.User;

public class SecurityContext {

    public SecurityContext() {
    }

    private static User activeUser;

    public static void logOut() {
        activeUser = null;
    }

    public static User getActiveUser() {
        return activeUser;
    }

    public static void setActiveUser(User activeUser) {
        SecurityContext.activeUser = activeUser;
    }

}
