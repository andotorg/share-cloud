package org.andot.share.oauth.server.share;

/**
 * 存储分享整合对象
 */
public class ShareAuthenticationContext {
    private static ThreadLocal<ShareAuthentication> holder = new ThreadLocal<>();

    public static ShareAuthentication getHolderItem() {
        return holder.get();
    }

    public static void addHolderItem(ShareAuthentication shareAuthentication) {
        holder.set(shareAuthentication);
    }

    public static void clearHolder() {
        holder.remove();
    }

}
