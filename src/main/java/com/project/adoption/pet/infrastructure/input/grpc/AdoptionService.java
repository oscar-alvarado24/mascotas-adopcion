package com.project.adoption.pet.infrastructure.input.grpc;


import com.project.adoption.pet.application.dto.AdoptionCreateResponse;
import com.project.adoption.pet.application.dto.AdoptionEmailRequest;
import com.project.adoption.pet.application.dto.AdoptionResponse;
import com.project.adoption.pet.application.dto.AdoptionServiceGrpc;
import com.project.adoption.pet.application.dto.AdoptionUpdateResponse;
import com.project.adoption.pet.application.dto.CreateAdoptionRequest;
import com.project.adoption.pet.application.dto.DeleteAdoptionRequest;
import com.project.adoption.pet.application.dto.DeleteAdoptionResponse;
import com.project.adoption.pet.application.dto.MultipleEmailsRequest;
import com.project.adoption.pet.application.dto.MultipleEmailsResponse;
import com.project.adoption.pet.application.dto.UpdateAdoptionRequest;
import com.project.adoption.pet.application.handler.IAdoptionHandler;
import com.project.adoption.pet.common.util.Constants;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

@GrpcService
@RequiredArgsConstructor
@Slf4j
public class AdoptionService extends AdoptionServiceGrpc.AdoptionServiceImplBase {

    private final IAdoptionHandler adoptionHandler;

    /**
     *
     * @param request  CreateAdoptionRequest with the adoption to be created
     * @param responseObserver
     */
    @Override
    public void createAdoption(CreateAdoptionRequest request, StreamObserver<AdoptionCreateResponse> responseObserver) {
        try {
            AdoptionCreateResponse response = adoptionHandler.createAdoption(request);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            log.error("Error creating adoption: ", e);
            responseObserver.onError(e);
        }
    }

    @Override
    public void getAdoptionsByEmail(AdoptionEmailRequest request, StreamObserver<AdoptionResponse> responseObserver) {
        try {
            AdoptionResponse adoptions = adoptionHandler.getAdoptionsByEmail(request.getEmail());
            responseObserver.onNext(adoptions);
            responseObserver.onCompleted();
        } catch (Exception e) {
            log.error("Error getting adoptions by email: ", e);
            responseObserver.onError(e);
        }
    }

    /**
     * <pre>
     * Retrieves all adoptions for multiple emails
     * </pre>
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void getAdoptionsByEmails(MultipleEmailsRequest request, StreamObserver<MultipleEmailsResponse> responseObserver) {
       MultipleEmailsResponse adoptions = adoptionHandler.getAdoptionsByEmails(request.getEmailsList());
        responseObserver.onNext(adoptions);
        responseObserver.onCompleted();
    }

    @Override
    public void updateAdoption(UpdateAdoptionRequest request, StreamObserver<AdoptionUpdateResponse> responseObserver) {
        try {
            AdoptionUpdateResponse response = adoptionHandler.updateAdoption(request);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            log.error("Error updating adoption: ", e);
            responseObserver.onError(e);
        }
    }

    @Override
    public void deleteAdoption(DeleteAdoptionRequest request, StreamObserver<DeleteAdoptionResponse> responseObserver) {
        try {
            DeleteAdoptionResponse response = adoptionHandler.deleteAdoption(request);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            log.error("Error deleting adoption: ", e);
            responseObserver.onError(e);
        }
    }


}

