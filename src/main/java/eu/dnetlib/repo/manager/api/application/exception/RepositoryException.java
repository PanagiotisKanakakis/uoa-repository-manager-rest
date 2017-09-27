package eu.dnetlib.repo.manager.api.application.exception;


public class RepositoryException extends RuntimeException {

    public RepositoryException(String errorMessage) {
        super(errorMessage);
    }
}
