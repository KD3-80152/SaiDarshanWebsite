
import Common from "./Common";
import { useEffect } from "react";
import FooterNav from "./FooterNav";
import React, { useState } from 'react';


const Pooja = () => {

  useEffect(() => {
    document.title = "Pooja";
  }, []);


  const [noOfPersons, setNoOfPersons] = useState(1);
  const [amount, setAmount] = useState(0);

  const handleNoOfPersonsChange = (event) => {
    setNoOfPersons(Number(event.target.value));
    // Calculate the amount based on the number of persons
    const newAmount = event.target.value === '1' ? 200 : 400; // Example calculation
    setAmount(newAmount);
  };

  const handleSubmit = () => {
    // Send the amount to the backend
    fetch('your-backend-url', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ amount }),
    })
      .then((response) => response.json())
      .then((data) => {
        // Handle response
      })
      .catch((error) => {
        console.error('Error:', error);
      });
  };


  return (
    <div style={{ margin: "auto" }}>
      <div>
        <Common />
      </div>

      <div id="pooja" className>
        <h4 style={{ color: "red", marginLeft: 10, marginTop: 10 }}>Pooja</h4>
        <hr />

        <div id="poojadetailsentry" className="row">

          <div style={{ display: "flex", alignItems: "center", marginLeft: 10, fontSize: 18 }}>
            <label class="textf ng-binding" for="inputLarge">
              Pooja
            <sup className="text-danger"> *</sup>
            </label>

            <div className="col-md-2 mb-2" style={{ marginLeft: 200, marginTop: -10 }}>
              <label htmlFor="pooja" className="form-label">
                {/* <b>Gender</b> */}
              </label>
              <select
                className="form-select"
                id="pooja"
                name="pooja"
              // onChange={handleUserInput}
              // value={user.gender}
              >
                <option value="">Select Pooja</option>
                <option value="ABHISHEK_POOJA_5_AM">ABHISHEK POOJA</option>
                <option value="SAI_SATYAVRAT_POOJA_12_PM">SAI SATYAVRAT POOJA</option>
              </select>
            </div>
          </div>

          <div style={{ display: "flex", alignItems: "center", marginLeft: 10, fontSize: 18 }}>
            <label class="textf ng-binding" for="inputLarge">
              Date
            <sup className="text-danger"> *</sup>
            </label>

            <div className="col-md-2 mb-2" style={{ marginLeft: 205, marginTop: -10 }}>
              <label htmlFor="date" className="form-label">

              </label>
              <input
                type="date"
                className="form-control ng-binding ng-untouched ng-valid"
                name="date"
                ng-model="pdqc.pageDeatils.userDetails.userFullName"
              />
            </div>

          </div>

          <div style={{ display: "flex", alignItems: "center", marginLeft: 10, fontSize: 18 }}>
            <label className="textf ng-binding" htmlFor="inputLarge">
              No Of Person
              <sup className="text-danger"> *</sup>
            </label>

            <div className="col-md-2 mb-2" style={{ marginLeft: 130, marginTop: 10 }}>
              <input
                type="radio"
                id="single"
                name="noofperson"
                className="form-check-input"
                value="1"
                style={{ marginLeft: 10 }}
                onChange={handleNoOfPersonsChange}
              />
              <label htmlFor="single" className="form-check-label" style={{ marginLeft: 10 }}>Single</label>


              <input
                type="radio"
                id="couple"
                name="noofperson"
                className="form-check-input"
                value="2"
                style={{ marginLeft: 10 }}
                onChange={handleNoOfPersonsChange}
              />
              <label htmlFor="couple" className="form-check-label" style={{ marginLeft: 10 }}>Couple</label>

            </div>
          </div>

          <div style={{ display: "flex", alignItems: "center", marginLeft: 10, fontSize: 18 }}>
            <label class="textf ng-binding" for="inputLarge">
              Total Amount(₹)
            <sup className="text-danger"> *</sup>
            </label>

            <div className="col-md-2 mb-2" style={{ marginLeft: 115, marginTop: -10 }}>
              <label htmlFor="date" className="form-label">

              </label>
              <input
                type="number"
                className="form-control ng-binding ng-untouched ng-valid"
                name="amount"
                value={amount}
                readOnly
                ng-model="pdqc.pageDeatils.userDetails.userFullName"
              />
            </div>

          </div>

        </div>

      </div>
      

      <div id="primarydetails">
        <h4 style={{ color: "red", marginLeft: 10, marginTop: 10 }}>
          Primary Devotee Details
        </h4>
        <hr />
        <div id="primarydetailsentry" className="row">
          <div
            id="fullNamebutton"
            class="textf col-sm-2"
            style={{ marginLeft: 10 }}
          >
            <label class="textf ng-binding" for="inputLarge">
              Name
              <sup className="text-danger"> *</sup>
            </label>
            <input
              type="text"
              className="form-control ng-binding ng-untouched ng-valid"
              name="name"
              ng-model="pdqc.pageDeatils.userDetails.userFullName"
            />
          </div>

          <div
            id="fullNamebutton"
            class="textf col-sm-1"
            style={{ marginLeft: 2 }}
          >
            <label class="textf ng-binding" for="inputLarge">
              Age
              <sup className="text-danger"> *</sup>
            </label>
            <input
              type="number"
              className="form-control ng-binding ng-untouched ng-valid"
              name="age"
              ng-model="pdqc.pageDeatils.userDetails.userFullName"
            />
          </div>

          <div
            id="fullNamebutton"
            class="textf col-sm-1"
            style={{ marginLeft: 2 }}
          >
            <label class="textf ng-binding" for="inputLarge" >
              Gender
              <sup className="text-danger"> *</sup>
            </label>
            <input
              type="text"
              className="form-control ng-binding ng-untouched ng-valid"
              name="gender"
              ng-model="pdqc.pageDeatils.userDetails.userFullName"
            />
          </div>

          <div
            id="fullNamebutton"
            class="textf col-sm-1"
            style={{ marginLeft: 2 }}
          >
            <label class="textf ng-binding" for="inputLarge">
              ID No.
              <sup className="text-danger"> *</sup>
            </label>
            <input
              type="text"
              className="form-control ng-binding ng-untouched ng-valid"
              name="idno"
              ng-model="pdqc.pageDeatils.userDetails.userFullName"
            />
          </div>

          <div
            id="idproof"
            class="textf col-sm-3"
            style={{ marginLeft: 2 }}
          >
            <label class="dropdf ng-binding" for="inputLarge">
              ID Proof
              <sup className="text-danger"> *</sup>
            </label>{" "}
            <br />
            <div class="textf col-sm-3">
              <select>
                <option value="">ID Proof</option>
                <option value="aadhar">AadharCard</option>
                <option value="pancard">PanCard</option>
                <option value="voterif">VoterId</option>
              </select>
            </div>
          </div>
          {/* <div id="loginButton" style={{ marginLeft: 10, marginTop: 15 }}>
            <button type="button" class="btn btn-danger">
              Login
            </button>
          </div> */}
          <div style={{ marginLeft: 10, marginTop: 15, display: 'flex' }}>
          <button type="button" class="btn btn-danger">
                Login
              </button>
            <div id="loginButton" style={{ marginLeft: 600 }}> 
              <button type="button" class="btn btn-primary" onClick={handleSubmit}>
              Submit
            </button>
            </div>
          </div>
          
        </div>
      </div>

      <div id="footerNote" style={{ marginLeft: 5 }}>
        <b>Note:-</b> <br />- Fields marked
        <sup className="text-danger"> *</sup>
        are Mandatory <br />
                                                                                                                                                                                                                                                                                        
        - Person on whose name service is booked should be present with his/her Photo Id and Acknowledgment in Shirdi while availing the <br/> 
        - Devotee can book one Pooja of each type in a single transaction.
                      
        <br />
        <b>
          {" "}
          - Quota for the 'Unavailable dates' may be available in future, in case of any cancellations from other devotees.
        </b>
        <br />
        <b>
          {" "}
          - Only single person or married couple (husband and wife) is allowed for each Pooja Coupon.
        </b>
      </div>

      <div>
        <FooterNav />
      </div>

    </div>
  );
};

export default Pooja;
