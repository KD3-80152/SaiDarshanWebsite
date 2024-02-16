import React from "react";
import Common from "./Common";
import ArtiRunningLine from "./ArtiRunningLine";
import FooterNav from "./FooterNav";
import { useEffect } from "react";

const Arti = () => {

  useEffect(()=>{
    document.title="Arti";
  },[]);

  return (
    <div style={{ margin: "auto" }}>
      <div>
        <Common />
        <ArtiRunningLine />
      </div>

      <div id="arti">
        <h4 style={{ color: "red", marginLeft: 10, marginTop: 10 }}>Arti</h4>
        <hr />

        <div id="darshandetailsentry" className="row">
          <div
            id="datebutton"
            class="textf col-sm-2"
            style={{ marginLeft: 10 }}
          >
            <label class="textf ng-binding" for="inputLarge">
              Date
              <sup className="text-danger"> *</sup>
            </label>
            <input
              type="date"
              className="form-control ng-binding ng-untouched ng-valid"
              name="name"
              ng-model="pdqc.pageDeatils.userDetails.userFullName"
            />
          </div>

          <div
            id="tepooja"
            class="textf col-sm-3"
            style={{ marginLeft: 2 }}
          >
            <label class="dropdf ng-binding" for="inputLarge">
              Pooja Type
              <sup className="text-danger"> *</sup>
            </label>{" "}
            <br />
            <div class="textf col-sm-3">
              <select>
                <option value="">Arti Type</option>
                <option value="kakadarti">Kakad Arti (Morning) 05:00-05:30</option>
                <option value="madhyamarti">Madhyan Arti(Noon) 12:00-12:30</option>
              </select>
            </div>
          </div>

          <div
            id="darshandetailsentry2"
            className="row"
            style={{ marginTop: 5 }}
          >
            <div
              id="datebutton"
              class="textf col-sm-2"
              style={{ marginLeft: 10 }}
            >
              <label class="textf ng-binding" for="inputLarge">
                No of Person
                <sup className="text-danger"> *</sup>
              </label>
              <input
                type="number"
                className="form-control ng-binding ng-untouched ng-valid"
                name="noofperson"
                ng-model="pdqc.pageDeatils.userDetails.userFullName"
              />
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

export default Arti;
