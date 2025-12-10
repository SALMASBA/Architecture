package com.example.Notification_Service.service;


import com.example.Notification_Service.grpc.NotificationRequest;
import com.example.Notification_Service.grpc.NotificationResponse;
import com.example.Notification_Service.grpc.NotificationServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class NotificationGrpcService extends NotificationServiceGrpc.NotificationServiceImplBase {

    @Override
    public void sendNotification(NotificationRequest request, StreamObserver<NotificationResponse> responseObserver) {
        // Logique de réception
        System.out.println("----------------------------------------------");
        System.out.println("🔔 NOUVELLE NOTIFICATION RECUE");
        // Utilise les getters (ils apparaîtront après la compilation Maven)
        System.out.println("Client ID : " + request.getCustomerId());
        System.out.println("Commande ID : " + request.getOrderId());
        System.out.println("Montant : " + request.getAmount());
        System.out.println("----------------------------------------------");

        // Réponse
        NotificationResponse response = NotificationResponse.newBuilder()
                .setMessage("Notification bien reçue par le serveur Notification")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}