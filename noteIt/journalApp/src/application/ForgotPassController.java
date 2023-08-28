package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class ForgotPassController extends SceneController implements Initializable {

	public SecurityModel securityModel = new SecurityModel();

	@FXML
	Label securityQuestionLabel;

	@FXML
	TextField securityAnswerInput;

	@FXML
	TextField newPasswordInput;

	@FXML
	TextField confirmNewPasswordInput;

	@FXML
	Label passwordMatchLabel;

	/**
	 * 
	 * This initializes the security question.
	 * 
	 * @param location  The location used to resolve relative paths for root object,
	 *                  otherwise null
	 * @param resources The resources used to localize the root object, otherwise
	 *                  null
	 *
	 */

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		securityQuestionLabel.setText(securityModel.getSecurityQuestion());

	}

	/**
	 * When the reset password button is clicked, the app switches to the login
	 * screen.
	 * 
	 * @param event The action of clicking the reset password button
	 * @throws Exception 
	 * 
	 */
	public void ResetPassword(ActionEvent event) throws Exception {

		try {
			if (securityModel.isCorrectSecurityAnswer(securityAnswerInput.getText())) {
				securityModel.saveNewPassword(newPasswordInput.getText());

				changeScene("LoginView.fxml");
			} else {
				passwordMatchLabel.setText("The security answer is not correct.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
