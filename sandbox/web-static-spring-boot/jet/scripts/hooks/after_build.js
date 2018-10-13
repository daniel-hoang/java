/**
  Copyright (c) 2015, 2018, Oracle and/or its affiliates.
  The Universal Permissive License (UPL), Version 1.0
*/
'use strict';
const fs = require('fs-extra');
const archiver = require('archiver');
module.exports = function (configObj) {
  return new Promise((resolve, reject) => {
    console.log("Running after_build hook.");

    // Just copy the web to spring-boot's resources/static
    fs.copy('web', '../src/main/resources/static', function (err) {
      if (err) {
        console.error(err);
      } else {
        console.log("success!");
      }
    });

    /* Code to archive to war file
    //change the extension of the my-archive.xxx file from .war to .zip as needed
    const output = fs.createWriteStream('my-archive.war');

    //leave unchanged, compression is the same for WAR or Zip file
    const archive = archiver('zip');

    output.on('close', () => {
      console.log('Files were successfully archived.');
      resolve();
    });

    archive.on('warning', (error) => {
      console.warn(error);
    });

    archive.on('error', (error) => {
      reject(error);
    });

    archive.pipe(output);
    archive.directory('web', false);
    archive.finalize();
    */
  });
};
