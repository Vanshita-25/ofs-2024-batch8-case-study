import 'oj-c/input-text';
import 'oj-c/input-password';
import 'ojs/ojknockout';
import 'oj-c/form-layout';
import 'oj-c/button';
import * as ko from "knockout";
type login = {
loginId : number;
password : string;
}
class LoginViewModel{

    loginId : ko.Observable<number | any>;
    password : ko.Observable<string | any>;

    constructor(){
        this.loginId = ko.observable(null);
        this.password = ko.observable(null);
        
    }
    public loginButtonClick = async (event: Event) => {
      const l : login={
        loginId : this.loginId(),
        password : this.password()
      };

        console.log(l);
        const requestBody = JSON.stringify(l);
        console.log(requestBody);
        let url = "http://localhost:8080/loginbanking/logins";
        try {
            const response = await fetch(url, {
              method: "post",
              headers: {
                "Content-type": "application/json; charset=UTF-8",
              },
              body:requestBody,
              mode: "cors",
            });
      
            if (response.ok) {
              const validate = await response.json();
              console.log("Login Status: ", validate);
              if(validate == 1){
                window.location.href = '?ojr=accounts';
              }
              else{
                alert("Login unsuccessful")
              }
      
            } else {
              console.error("Error validating", response.status, response.statusText);
            }
          } catch (error) {
            console.error("Error validating:", error);
          }
    }

}
export = LoginViewModel;