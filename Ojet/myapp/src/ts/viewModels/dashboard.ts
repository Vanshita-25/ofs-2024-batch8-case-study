/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import * as AccUtils from "../accUtils";
import * as ko from "knockout";
import "ojs/ojknockout";
import 'oj-c/form-layout';
import "oj-c/input-number";
import 'oj-c/input-text';
import 'oj-c/input-password';
import 'oj-c/select-multiple';
import "oj-c/button";
import ArrayDataProvider = require('ojs/ojarraydataprovider');
import Message = require('ojs/ojmessaging');
import { MessageBannerItem, CMessageBannerElement } from 'oj-c/message-banner';
import MutableArrayDataProvider = require('ojs/ojmutablearraydataprovider');
import 'oj-c/message-banner';

import { RESTDataProvider } from 'ojs/ojrestdataprovider';
import 'ojs/ojtable';
import { ojTable } from 'ojs/ojtable';
import * as deptArray from 'text!../cookbook/dataprovider/arrayData.json';


type DemoCustomDetailMessageBannerItem = MessageBannerItem & {
  id: string;
  actions?: [CustomAction, CustomAction];
};
type CustomAction = {
  link?: string;
  title?: string;
};
const customDetailMessages: DemoCustomDetailMessageBannerItem[] = [
  {
    id: 'message1',
    severity: 'warning',
    summary: 'Warning message summary',
    detail:
      "This message uses the 'detail-template-value' property of the oj-c-message-banner component to choose the 'actions' template from the provided dynamic template slots." +
      'This overrides the default detail and renders the custom detail text and the action items.',
    actions: [
      { title: 'Learn more', link: '#learnMore' },
      { title: 'View details', link: '#viewDetails' }
    ],
    closeAffordance: 'off'
  }
];
type DemoMessageBannerItem = MessageBannerItem & {
  id: string;
};
class DashboardViewModel {
  firstName: ko.Observable<string> | ko.Observable<any>;
  salary : ko.Observable<number> | ko.Observable<any>;
  source : ko.Observable<string> | ko.Observable<any>;
  sourcesOfIncome: ArrayDataProvider<string,string>;
  name: ko.Observable<string> | ko.Observable<any>;
  password: ko.Observable<string | null>;
  clickedButton: ko.Observable<string>;
  username : ko.Observable<string | null>;
  email : ko.Observable<string | null>;
  street : ko.Observable<string|null>
  suite : ko.Observable<string| null>;
  Data : ko.Observable<string | null>;

  
  readonly customDetailMessages: MutableArrayDataProvider<
      string,
      DemoCustomDetailMessageBannerItem
    >;
    readonly closeCustomDetailMessage = (
      event: CMessageBannerElement.ojClose<string, DemoMessageBannerItem>
    ) => {
      let data = this.customDetailMessages.data.slice();
      const closeMessageKey = event.detail.key;
  
      data = data.filter((message) => (message as any).id !== closeMessageKey);
      this.customDetailMessages.data = data;
    };
  
  constructor() {
    this.firstName = ko.observable(null);
    this.salary = ko.observable(null);
    this.password = ko.observable(null);
    this.source = ko.observable(null);
    this.name = ko.observable(null);
    this.username = ko.observable(null);
    this.street = ko.observable(null);
    this.suite = ko.observable(null);
    this.Data = ko.observable(null);
    this.email = ko.observable(null);
    this.clickedButton = ko.observable("(None clicked yet)");
    let sources = [
      { value: 'LA', label: 'Land Property' },
      { value: 'SM', label: 'Stock Market' },
      { value: 'J', label: 'Job' },
      { value: 'B', label: 'Business' },
      { value: 'M', label: 'Miscellaneous' }
    ];
  
    this.sourcesOfIncome = new ArrayDataProvider(sources, {
      keyAttributes: 'value'
    });
    this.customDetailMessages = new MutableArrayDataProvider(customDetailMessages, {
      keyAttributes: 'id'
    });
   // Update method
 


  }
  public buttonClick = async (event: Event) => {
    console.log((event.currentTarget as HTMLElement).tagName);
    //Send request to backend
    this.clickedButton((event.currentTarget as HTMLElement).id);
    let id = parseInt(this.name());
    let url = "https://jsonplaceholder.typicode.com/users/"+id;
    let res = await fetch(url);
    let jsonData = await res.json();
    this.name(jsonData.name);
    this.username(jsonData.username);
    this.email(jsonData.email);
    this.street(jsonData.address.street);
    this.suite(jsonData.address.suite);
    this.Data("Name: " + this.name()+ " Username: "+this.username()+ " Email: "+this.email()+" Street: "+this.street()+ " Suite: "+this.suite())
    console.log(jsonData);
    alert("Name: " + this.name() + " and Salary is: " + this.salary());
    return true;
  };
}

export = DashboardViewModel;
