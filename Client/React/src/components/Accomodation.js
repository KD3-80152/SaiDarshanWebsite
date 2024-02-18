import React from 'react'
import Common from './Common';
import AccomodationRunningLine from './AccomodationRunningLine';
import { useEffect } from 'react'
import { useState } from 'react'
import FooterNav from "./FooterNav";


const Accomodation = () => {

  useEffect(() => {
    document.title = "Accomodation";
  }, []);

  const [noOfRooms, setNoOfRooms] = useState(1);
  const [noOfDays, setNoOfDays] = useState(1);
  const [amount, setAmount] = useState(500); // Assuming charge for each room is 500

  const handleNoOfRoomsChange = (e) => {
    const rooms = parseInt(e.target.value);
    setNoOfRooms(rooms);
    calculateAmount(rooms, noOfDays);
  };

  const handleNoOfDaysChange = (e) => {
    const days = parseInt(e.target.value);
    setNoOfDays(days);
    calculateAmount(noOfRooms, days);
  };

  const calculateAmount = (rooms, days) => {
    const totalAmount = rooms * 500 * days; // Assuming charge for each room is 500
    setAmount(totalAmount);
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
    <div style={{ margin: 'auto' }}>

      <div>
        <Common />
        <AccomodationRunningLine />
      </div>

      <div id="accomodation">
        <h4 style={{ color: "red", marginLeft: 10, marginTop: 10 }}>Accommodation</h4>
        <hr />

        <div id="accomodationdetailsentry" className="row">
          <div
            id="datebutton"
            class="textf col-sm-2"
            style={{ marginLeft: 10 }}
          >
            <label class="textf ng-binding" for="inputLarge">
              Check-in-Date
              <sup className="text-danger"> *</sup>
            </label>
            <input
              type="date"
              className="form-control ng-binding ng-untouched ng-valid"
              name="date"
              ng-model="pdqc.pageDeatils.userDetails.userFullName"
            />
          </div>

          <div
            id="timeslotbutton"
            class="textf col-sm-2"
            style={{ marginLeft: 10 }}
          >
            <label class="textf ng-binding" for="inputLarge">
              Check-in-Time
              <sup className="text-danger"> *</sup>
            </label>
            <input
              type="time"
              className="form-control ng-binding ng-untouched ng-valid"
              name="time"
              ng-model="pdqc.pageDeatils.userDetails.userFullName"
            />
          </div>

          <div
            id="darshandetailsentry2"
            className="row"
            style={{ marginTop: 5 }}
          >
            <div
              id="roombutton"
              class="textf col-sm-2"
              style={{ marginTop: 5, marginLeft: 10 }}
            >
              <label class="textf ng-binding" for="inputLarge">
                No of Rooms
                <sup className="text-danger"> *</sup>
              </label>
              <select
                className="form-select"
                id="noofdays"
                name="noofdays"
                type="number"
                pattern="[1-5]"
                title="Please select a number between 1 and 5"
                value={noOfRooms}
  onChange={handleNoOfRoomsChange}

              // onChange={handleUserInput}
              // value={user.gender}
              >
                <option value="">Select no of  Days</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
              </select>
            </div>

            <div
              id="daysbutton"
              class="textf col-sm-2"
              style={{ marginLeft: 10 }}
            >
              <label class="textf ng-binding" for="inputLarge">
                No of days
                <sup className="text-danger"> *</sup>
              </label>
              <select
                className="form-select"
                id="noofdays"
                name="noofdays"
                type="number"
                value={noOfDays}
  onChange={handleNoOfDaysChange}
              // onChange={handleUserInput}
              // value={user.gender}
              >
                <option value="">Select no of  Days</option>
                <option >1</option>
              </select>
            </div>


            <div
              id="amountbutton"
              class="textf col-sm-2"
              style={{ marginLeft: 10 }}
            >
              <label class="textf ng-binding" for="inputLarge">
                Amount
                <sup className="text-danger"> *</sup>
              </label>
              <input
                type="number"
                className="form-control ng-binding ng-untouched ng-valid"
                name="amount"
                ng-model="pdqc.pageDeatils.userDetails.userFullName"
                value={amount}
                disabled
              />
            </div>
            
            <div id="submitButton" style={{ marginLeft: 10,marginTop:20 }}> 
              <button type="button" class="btn btn-primary" onClick={handleSubmit}>
              Submit
            </button>
            
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
            <label class="textf ng-binding" for="inputLarge">
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
            id="fullNamebutton"
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
          <div id="loginButton" style={{ marginLeft: 10, marginTop: 15 }}>
            <button type="button" class="btn btn-danger">
              Login
            </button>
          </div>
        </div>
      </div>

      <div id="footerNote" style={{ marginLeft: 5 }}>
        <b>Note:-</b> <br />- Fields marked
        <sup className="text-danger"> *</sup>
        are Mandatory <br />
        <b>
          {" "}
          - At the time of verification, all the devotees should produce the
          same original Photo IDs furnished at the time of booking.{" "}
        </b>{" "}
        <br />
        <b>
          {" "}
          - Devotees will not be allowed to avail the service in case of any
          mismatch.
        </b>
        <br />
        <b>
          {" "}
          - Quota for the 'Unavailable dates' may be available in future, in
          case of any cancellations from other devotees.
        </b>
      </div>

      <div>
        <FooterNav />
      </div>




    </div>


  );
};

export default Accomodation