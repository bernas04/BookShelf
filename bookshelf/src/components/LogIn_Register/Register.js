import React, { useState } from "react";

import Form from "react-bootstrap/Form";
import { useNavigate } from 'react-router-dom';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css'
import Button from "react-bootstrap/Button";

import "./Register.css";

export default function Register() {
    const navigate = useNavigate();

  function handleClick(){
    navigate("/")
  }

  const [name, setName] = useState("");
  const [password, setPassword] = useState("");
  const [username, setUsername] = useState("");
  const [road, setRoad] = useState("");
  const [city, setCity] = useState("");
  const [country, setCountry] = useState("");
  const [zipCode, setZipCode] = useState("");

  const [birthDate, setBirthdate] = useState(null);



  function validateForm() {
    return name.length > 0 && password.length > 0 && username.length > 0 && birthDate!==null && road.length>0 && city.length>0 && country.length>0 && zipCode.length>0;
  }

  function handleSubmit(event) {
    event.preventDefault();



    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json',  'Access-Control-Allow-Origin': '*'},
      body: JSON.stringify({name: name, password: password, birthDate: birthDate, username:username, address:{road: road, city:city, country:country, zipcode:zipCode}})
    };

    console.log("---> " ,requestOptions.body)

    fetch(`http://localhost:8080/api/auth/registerClient`, requestOptions)
    .then(response => response.json())
    .then(data => { 
        if (data.error){
        }
        if (data.password!==null){
            console.log("LogIn")
            localStorage.setItem("info", JSON.stringify(data));
            navigate("/")
        }
    });

  }

  return (

    <div className="Login">
        <div className="cardRegist">
            <div className="Signup">Signup</div>
            
            
            <Form onSubmit={handleSubmit}>

            <Form.Group size="lg" controlId="email">

            {/* <Form.Label className="">User Name: </Form.Label> */}
            <Form.Control className="forms"
                type="text"
                value={name}
                onChange={(e) => setName(e.target.value)}
                placeholder="Name"
            />

            <Form.Control className="forms"
                type="text"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                placeholder="Username"
            />

            </Form.Group>

            <Form.Group size="lg" controlId="password">

            {/* <Form.Label>Password</Form.Label> */}

            <Form.Control className="forms"

                type="password"

                value={password}

                onChange={(e) => setPassword(e.target.value)}
                placeholder="Password"

            />

            <Form.Control className="forms"

            type="text"

            value={road}

            onChange={(e) => setRoad(e.target.value)}
            placeholder="Road"

            />

            <Form.Control className="forms"

            type="text"

            value={city}

            onChange={(e) => setCity(e.target.value)}
            placeholder="City"

            />

            <Form.Control className="forms"

            type="text"

            value={zipCode}

            onChange={(e) => setZipCode(e.target.value)}
            placeholder="ZipCode"

            />

            <Form.Control className="forms"

            type="text"

            value={country}

            onChange={(e) => setCountry(e.target.value)}
            placeholder="Country"

            />
            
            <DatePicker className="forms" placeholderText="Birthdate" 
              selected={birthDate} 
              
              onChange={
                (date) =>{
                  setBirthdate(date);
                }
              } 

              dateFormat='dd-MM-yyyy'  
              showYearDropdown
              scrollableYearDropdown
            />            

            </Form.Group>

            <Button  className="button-42" block size="lg" type="submit" disabled={!validateForm()}>

            Register

            </Button>

            </Form>
            <div className="signintext">Do you already have an account?</div>
            <Button className="button-3" onClick={handleClick} block variant="secondary">Login</Button>



        </div>

     

    </div>

  );

}