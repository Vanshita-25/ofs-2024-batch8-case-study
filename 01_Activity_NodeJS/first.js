//let os = require("os");

//cant use above syntax to import as we added "type":"module" to package.json to use import below
import os from 'os';
console.log(os.platform() + os.arch());

//Readline sync is the scanner(java) for node
