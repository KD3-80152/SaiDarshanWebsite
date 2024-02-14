import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';

const Login = () => {
   const url = 'http://localhost:8443/login';

    const [formData, setFormData] = useState({
        email: '',
        password: ''
    });

    const [errors, setErrors] = useState({});
    const [valid, setValid] = useState(true);
    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();
        let isValid = true;
        let validationErrors = {};

        if (formData.email === "" || formData.email === null) {
            isValid = false;
            validationErrors.email = "Email Required";
        } else if (!/\S+@\S+\.\S+/.test(formData.email)) {
            isValid = false;
            validationErrors.email = "Email is not valid";
        }

        if (formData.password === "" || formData.password === null) {
            isValid = false;
            validationErrors.password = "Password Required";
        } else if (formData.password.length < 8) {
            isValid = false;
            validationErrors.password = "Password length should be at least 8 characters";
        }

        setErrors(validationErrors);
        setValid(isValid);

        if (isValid) {
            axios.get(url)
                .then(result => {
                    const user = result.data.find(user => user.email === formData.email);
                    if (user) {
                        if (user.password === formData.password) {
                            alert("Login Successfully");
                            navigate('/');
                        } else {
                            setErrors({ password: "Wrong Password" });
                        }
                    } else {
                        setErrors({ email: "Wrong Email" });
                    }
                })
                .catch(err => console.log(err));
        }
    };

    return (
        <div className="container-fluid" style={{backgroundImage:"https://artworkbird.co.in/sai-baba-marathi-png/", margin:"auto"}} >
            <div >
                <div className="">
                    <div className="signup-form">
                        <form className="" onSubmit={handleSubmit}>
                            <h4 className=" text-secondary">Login Your Account</h4>
                            <div className="row">
                                <div >
                                    <label>Email<span className="text-danger">*</span></label>
                                    <input type="email" name="email" className="form-control" placeholder="Enter Email" onChange={(event) => setFormData({ ...formData, email: event.target.value })} />
                                    {valid ? <></> : <span className="text-danger">{errors.email}</span>}
                                </div>
                                <div className="" style={{marginTop:10}}>
                                    <label>Password<span className="text-danger">*</span></label>
                                    <input type="password" name="password" className="form-control" placeholder="Enter Password" onChange={(event) => setFormData({ ...formData, password: event.target.value })} />
                                    {valid ? <></> : <span className="text-danger">{errors.password}</span>}
                                </div>
                                <div className="">
                                    {/* <button type="submit" className="btn btn-primary float-end">Login Now</button> */}
                                    <button class="btn btn-primary float-end" style={{ backgroundColor: 'orange', borderColor: 'orange',marginTop:10 }}
                                     onClick={{}} >Login Now</button>
                                </div>
                            </div>
                        </form>
                        {/* <p className="text-center mt-3 text-secondary">If you do not have an account, Please <Link to="/registration">Register Now</Link></p> */}
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Login;