/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import * as AccUtils from "../accUtils";
import 'ojs/ojknockout';
import 'oj-c/text-area';
import 'oj-c/input-number';
import 'oj-c/input-text';
import 'oj-c/input-password';
import 'oj-c/form-layout';
import 'oj-c/button';
import * as ko from "knockout";
import 'oj-c/collapsible';
import { RESTDataProvider } from 'ojs/ojrestdataprovider';

type D = { "firstName": string; 
            "lastName" : string ; 
            "address1" : string ; 
            "address2" : string ; 
            "address3" : string ; 
            "city" : string ; 
            "state" : string ; 
            "zip" : number ; 
            "email" : string ; 
            "password" : string ;
            "approvalStatus" : string;
          };

class DashboardViewModel {
  firstName : ko.Observable<string | any>;
  lastName : ko.Observable<string | any>;
  address1 : ko.Observable<string | any>;
  address2 : ko.Observable<string | any>;
  address3 : ko.Observable<string | any>;
  city : ko.Observable<string | any>;
  state : ko.Observable<string | any>;
  zip : ko.Observable<number | any>;
  email : ko.Observable<string | any>;
  password : ko.Observable<string | any>;
  approvalStatus : ko.Observable<string | any>;
  customerId : ko.Observable<number | any>;



  constructor(){
    this.firstName = ko.observable(null);
    this.lastName = ko.observable(null);
    this.address1 = ko.observable(null);
    this.address2 = ko.observable(null);
    this.address3 = ko.observable(null);
    this.city = ko.observable(null);
    this.state = ko.observable(null);
    this.zip = ko.observable(null);
    this.email = ko.observable(null);
    this.password = ko.observable(null);
    this.approvalStatus = ko.observable(null);
    this.customerId = ko.observable(null);


  }
  public loginHref = async (event : Event) => {
    window.location.href = '?ojr=login';
  };
  public submitButtonClick  = async (event: Event) => {
    const customer : D = {
      firstName : this.firstName(),
      lastName : this.lastName(),
      address1 : this.address1(),
      address2 : this.address2(),
      address3 : this.address3(),
      city : this.city(),
      state : this.state(),
      zip : this.zip(),
      email : this.email(),
      password : this.password(),
      approvalStatus : 'Approved'
    };
    console.log(customer);
    const requestBody = JSON.stringify(customer);
    console.log(requestBody);

    let url = "http://localhost:8080/banking/customer";

    
    try {
      const response = await fetch(url, {
        method: "POST",
        headers: {
          "Content-type": "application/json; charset=UTF-8",
        },
        body: requestBody,
        mode: "cors",
      });

      if (response.ok) {
        const addedRow = await response.json();
        console.log("Added row:", addedRow);
        this.customerId(addedRow.customerId);

      } else {
        console.error("Error adding row:", response.status, response.statusText);
      }
    } catch (error) {
      console.error("Error adding row:", error);
    }
    
  };

}


export = DashboardViewModel;
