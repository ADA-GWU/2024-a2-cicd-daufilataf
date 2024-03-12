package ada.edu.demo.webtest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WebInterfaceTests {

	@Autowired
	private WebDriver webDriver;

	@LocalServerPort
	private int port;

	@Test
	@Order(1)
	@DisplayName("Create a user")
	public void CreateUser() {
		webDriver.get("http://localhost:" + port + "/student/new");

		WebElement studentIdInput = webDriver.findElement(By.id("studentId"));
		WebElement firstNameInput = webDriver.findElement(By.id("firstName"));
		WebElement lastNameInput = webDriver.findElement(By.id("lastName"));
		WebElement emailInput = webDriver.findElement(By.id("email"));

		// Check if such a field exists
		assertNotNull(firstNameInput);

		try {
			studentIdInput.sendKeys("1");
			Thread.sleep(2000);
			firstNameInput.sendKeys("Nigar");
			Thread.sleep(2000);
			lastNameInput.sendKeys("Salayeva");
			Thread.sleep(2000);
			emailInput.sendKeys("ns@ada.edu.az");
			Thread.sleep(2000);
		} catch (Exception ex) {
			System.out.println(ex);
		}

		// Find and submit the form (assuming there's a submit button with a specific
		// attribute)
		WebElement submitButton = webDriver.findElement(By.id("submit"));
		submitButton.click();
	}

	@Test
	@Order(2)
	@DisplayName("Check the created user")
	public void CheckUser() {
		// Check if the student is added
		webDriver.get("http://localhost:" + port + "/student/list");
		List<WebElement> bodyElementFName = webDriver.findElements(By.xpath("//*[contains(text(), 'Nigar')]"));
		List<WebElement> bodyElementLName = webDriver.findElements(By.xpath("//*[contains(text(), 'Salayeva')]"));
		System.out.println("Element result" + bodyElementLName);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		// Check if the text "Jamal" is present in the page content
		assert (bodyElementFName.size() == 1);
		assert (bodyElementLName.size() == 1);
	}

	@Test
	@Order(3)
	@DisplayName("Update a user")
	public void UpdateUser() {
		webDriver.get("http://localhost:" + port + "/student/update?id=1");

		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")));

		// Find input fields
		WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
		WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

		// Find checkboxes for Web & Mobile 2 and SDP 1
		WebElement webMobile2Checkbox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='2']")));
		WebElement sdp2Checkbox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='8']")));

		WebElement dancingCheckbox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='9']")));

		// Check if such fields exist
		assertNotNull(firstNameInput);
		assertNotNull(lastNameInput);
		assertNotNull(emailInput);
		assertNotNull(webMobile2Checkbox);
		assertNotNull(sdp2Checkbox);
		assertNotNull(dancingCheckbox);

		try {
			Thread.sleep(1000);

			firstNameInput.clear();
			Thread.sleep(1000);

			firstNameInput.sendKeys("Fuad");
			Thread.sleep(1000);

			lastNameInput.clear();
			Thread.sleep(1000);

			lastNameInput.sendKeys("Fataliyev");
			Thread.sleep(1000);

			emailInput.clear();
			Thread.sleep(1000);

			emailInput.sendKeys("fuad@gmail.com");
			Thread.sleep(1000);

			// Check the checkboxes for Web & Mobile 2 and SDP 1
			webMobile2Checkbox.click();
			Thread.sleep(1000);
			sdp2Checkbox.click();
			Thread.sleep(1000);
			dancingCheckbox.click();
			Thread.sleep(1000);
		} catch (Exception ex) {
			System.out.println(ex);
		}

		// Find and submit the form (assuming there's a submit button with a specific
		// attribute)
		WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		submitButton.click();
	}

	@Test
	@Order(4) // Adjust the order based on your test sequence
	@DisplayName("Check the updated user")
	public void CheckUpdatedUser() {
		// Check if the updated user is reflected
		webDriver.get("http://localhost:" + port + "/student/list");
		List<WebElement> bodyElementFName = webDriver
				.findElements(By.xpath("//*[contains(text(), 'Fuad')]"));
		List<WebElement> bodyElementLName = webDriver
				.findElements(By.xpath("//*[contains(text(), 'Fataliyev')]"));

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		// Check if the updated user's name is present in the page content
		assert (bodyElementFName.size() == 1);
		assert (bodyElementLName.size() == 1);
	}

}
