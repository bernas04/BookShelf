import React, { useState } from "react";

import Form from "react-bootstrap/Form";
import { useNavigate } from 'react-router-dom';

import Button from "react-bootstrap/Button";

import "./Register.css";

export default function Register() {
    const navigate = useNavigate();

  function handleClick(){
    navigate("/")
  }

  const [email, setEmail] = useState("");

  const [password, setPassword] = useState("");

  function validateForm() {

    return email.length > 0 && password.length > 0;

  }

  function handleSubmit(event) {

    event.preventDefault();

  }

  return (

    <div className="Login">
        <div className="card">
            <div className="Signup">Signup</div>
            
            
            <Form onSubmit={handleSubmit}>

            <Form.Group size="lg" controlId="email">

            {/* <Form.Label className="">User Name: </Form.Label> */}
            <Form.Control className="forms"

                type="email"

                value={password}

                onChange={(e) => setPassword(e.target.value)}
                placeholder="email"

            />

            <Form.Control className="forms"

                autoFocus

                type="email"

                value={email}

                onChange={(e) => setEmail(e.target.value)}
                placeholder="User Name"

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

                type="birthDate"

                value={password}

                onChange={(e) => setPassword(e.target.value)}
                placeholder="Birth Date"

            />
            

            </Form.Group>

            <Button  className="button-42" block size="lg" type="submit" disabled={!validateForm()}>

            Register

            </Button>

            </Form>
            <div className="signintext" onClick={handleClick}>Do you already have an account? Log In</div>

        </div>

     

    </div>

  );

}