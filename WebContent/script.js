  // Import the functions you need from the SDKs you need
  import { initializeApp } from "https://www.gstatic.com/firebasejs/10.12.3/firebase-app.js";
  import {getDatabase,ref,set,get,child} from "https://www.gstatic.com/firebasejs/10.12.3/firebase-database.js";

  // Your web app's Firebase configuration
  const firebaseConfig = {
    apiKey: "AIzaSyCSgD--k433-Qo3xeEoi-kiNBwAgZbH6UE",
    authDomain: "formdata-1ac00.firebaseapp.com",
    projectId: "formdata-1ac00",
    storageBucket: "formdata-1ac00.appspot.com",
    messagingSenderId: "490688857851",
    appId: "1:490688857851:web:ed9c0493989f209bb1125e"
  };

  // Initialize Firebase
  const app = initializeApp(firebaseConfig);
  const db=getDatabase(app);
  document.getElementById("SUBMIT").addEventListener('click',function(e){

    set(ref(db,'user/'+document.getElementById("newuser").value),
    {
        username: document.getElementById("newuser").value,
        FirstName: document.getElementById("firstname").value,
        LastName: document.getElementById("lastname").value,
        Email: document.getElementById("email").value,
        Phone: document.getElementById("phone").value,
        DateOfBirth: document.getElementById("dob").value,
        Gender: document.getElementById("gender").value,
        Password: document.getElementById("password").value,
    })
        alert("SignUp successful");
  })