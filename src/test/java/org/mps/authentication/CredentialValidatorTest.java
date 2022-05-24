package org.mps.authentication;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CredentialValidatorTest {
    @Test
    public void ShouldReturnValidationOkIfValidationIsCorrect(){

    }

    @Test
    public void ShouldReturnBirthdayInvalidIdDateIsInvalid(){

    }

    @Test
    public void ShouldReturnPasswordInvalidIfPasswordIsInvalid(){
        var date = Mockito.mock(Date.class);
        Mockito.when(date.validate()).thenReturn(true);

        var password = Mockito.mock(PasswordString.class);
        Mockito.when(password.validate()).thenReturn(false);

        var credentialStore = Mockito.mock(CredentialStore.class);
        Mockito.when(credentialStore.credentialExists(date, password)).thenReturn(true);

        var credentialValidator = new CredentialValidator(date, password, credentialStore);

        var expectedResult = CredentialValidator.ValidationStatus.PASSWORD_INVALID;
        var obtainedResult = credentialValidator.validate();

        assertEquals(expectedResult, obtainedResult);
    }

    @Test
    public void ShouldReturnCredentialInvalidIfCredentialDoesNotExist(){
        var date = Mockito.mock(Date.class);
        Mockito.when(date.validate()).thenReturn(true);

        var password = Mockito.mock(PasswordString.class);
        Mockito.when(password.validate()).thenReturn(true);

        var credentialStore = Mockito.mock(CredentialStore.class);
        Mockito.when(credentialStore.credentialExists(date, password)).thenReturn(false);

        var credentialValidator = new CredentialValidator(date, password, credentialStore);

        var expectedResult = CredentialValidator.ValidationStatus.CREDENTIAL_INVALID;
        var obtainedResult = credentialValidator.validate();

        assertEquals(expectedResult, obtainedResult);
    }
}
