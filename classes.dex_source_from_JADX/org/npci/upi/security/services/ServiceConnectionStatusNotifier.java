package org.npci.upi.security.services;

public interface ServiceConnectionStatusNotifier {
    void serviceConnected(CLServices cLServices);

    void serviceDisconnected();
}
