package com.greenowl.config;

import com.greenowl.model.User;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.swing.text.StyledEditorKit;
import java.util.Objects;

/**
 * Created by acube on 08.06.2016.
 * Package com.greenowl.config
 *
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */
public class WebSecurity {

    public static User currentUser;
    public static HttpSession session;
    public static Cookie cookie;

    public WebSecurity() {}

    public static User getCurrentUser() {
        return currentUser;
    }
    public static void setCurrentUser(User currentUserSession) {
        WebSecurity.currentUser = currentUserSession;
    }

    public static Cookie getCookie() {
        return cookie;
    }
    public static void setCookie(Cookie cookie) {
        WebSecurity.cookie = cookie;
    }

    public static HttpSession getSession() {
        return session;
    }
    public static void setSession(HttpSession session) {
        WebSecurity.session = session;
    }

    public static Boolean checkTransaction(String id) {
        return (currentUser != null)
                && (cookie != null && Objects.equals(cookie.getName(), "USER") && Objects.equals(cookie.getValue(), currentUser.getPassword()))
                && (session != null && Objects.equals(session.getId(), id));
    }

    public static void resetTransaction() {
        setCurrentUser(null);
        setSession(null);
        setCookie(null);
    }
}
