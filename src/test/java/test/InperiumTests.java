package test;

import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import models.Company;
import models.Contact;
import models.User;
import org.testng.annotations.Test;

import java.util.UUID;


public class InperiumTests extends BaseTest {
    User user = new User("administrator@inperium.com", "123");
    Company company = new Company(UUID.randomUUID().toString(), UUID.randomUUID().toString() + ".com");
    Company updatedCompany = new Company(UUID.randomUUID().toString(), UUID.randomUUID().toString() + ".com");
    Contact contact = new Contact(UUID.randomUUID().toString() + "@gmail.com", UUID.randomUUID().toString(), UUID.randomUUID().toString(), "Massa Consulting");
    Contact updatedContact = new Contact(UUID.randomUUID().toString() + "@gmail.com", UUID.randomUUID().toString(), UUID.randomUUID().toString(), "Massa Consulting");

    @Test(description = "Create company.", priority = 1)
    @Link("https://sell.inperium.dev")
    @Issue("INS-1845")
    public void createCompany() {
        loginPage
                .openPage()
                .login(user)
                .createCompanyButtonClick()
                .provideCompanyDataAndSubmit(company)
                .verifyThatCompanyWasCreated();
    }

    @Test(description = "Update company.", priority = 2)
    public void updateCompany() {
        loginPage
                .openPage()
                .login(user)
                .searchAndOpenCompany(company)
                .updateAndSaveCompany(updatedCompany)
                .verifyUpdatedCompany(updatedCompany);
    }

    @Test(description = "Delete contact.", priority = 3)
    public void deleteCompany() {
        loginPage
                .openPage()
                .login(user)
                .searchAndOpenCompany(updatedCompany)
                .deleteCompany()
                .verifyThatCompanyWasDeleted(updatedCompany);
    }

    @Test(description = "Create contact.", priority = 4)
    public void createContact() {
        loginPage
                .openPage()
                .login(user);
        contactsPage
                .openPage()
                .createContactButtonClick()
                .provideContactDataAndSubmit(contact)
                .verifyThatContactWasCreated();
    }

    @Test(description = "Update contact.", priority = 5)
    public void updateContact() {
        loginPage
                .openPage()
                .login(user);
        contactsPage
                .openPage()
                .searchAndOpenContact(contact)
                .updateAndSaveContact(updatedContact)
                .verifyUpdatedContact(updatedContact);
    }

    @Test(description = "Delete contact.", priority = 6)
    public void deleteContact() {
        loginPage
                .openPage()
                .login(user);
        contactsPage
                .openPage()
                .searchAndOpenContact(updatedContact)
                .deleteContact()
                .verifyThatContactWasDeleted(updatedContact);
    }

}
