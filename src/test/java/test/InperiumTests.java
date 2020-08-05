package test;

import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import models.Company;
import models.Contact;
import models.User;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.UUID;

public class InperiumTests extends BaseTest {
    User user = new User("administrator@inperium.com", "123");
    Company company = new Company(UUID.randomUUID().toString(), UUID.randomUUID().toString() + ".com");
    Company updatedCompany = new Company(UUID.randomUUID().toString(), UUID.randomUUID().toString() + ".com");
    Contact contact = new Contact(UUID.randomUUID().toString() + "@gmail.com", UUID.randomUUID().toString(), UUID.randomUUID().toString(), "Erat Eget Corporation");
    Contact updatedContact = new Contact(UUID.randomUUID().toString() + "@gmail.com", UUID.randomUUID().toString(), UUID.randomUUID().toString(), "Erat Eget Corporation");

    @Test(description = "1. Create company.", priority = 1)
    @Link("https://sell.qa.inperium.dev")
    @Issue("INS-1845")
    public void createCompany() {
        loginPage
                .openPage()
                .login(user);
        companiesPage
                .openPage()
                .createCompanyButtonClick()
                .provideCompanyDataAndSubmit(company)
                .verifyThatCompanyWasCreated(company);
    }

    @Test(description = "2. Update company.", priority = 2)
    @Ignore
    public void updateCompany() {
        loginPage
                .openPage()
                .login(user)
                .searchAndOpenCompany(company)
                .updateAndSaveCompany(updatedCompany)
                .verifyUpdatedCompany(updatedCompany);
    }

    @Test(description = "3. Delete company.", priority = 3)
    @Ignore
    public void deleteCompany() {
        loginPage
                .openPage()
                .login(user)
                .searchAndOpenCompany(updatedCompany)
                .deleteCompany()
                .verifyThatCompanyWasDeleted(updatedCompany);
    }

    @Test(description = "4. Create contact.", priority = 4)
    public void createContact() {
        loginPage
                .openPage()
                .login(user);
        contactsPage
                .openPage()
                .createContactButtonClick()
                .provideContactDataAndSubmit(contact)
                .verifyThatContactWasCreated(contact);
    }

    @Test(description = "5. Update contact.", priority = 5)
    @Ignore
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

    @Test(description = "6. Delete contact.", priority = 6)
    @Ignore
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
