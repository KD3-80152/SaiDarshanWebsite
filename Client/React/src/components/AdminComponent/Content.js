import React from "react";
import { ListGroup } from "reactstrap";
import { Link, Outlet } from "react-router-dom";

const Content = () => {
  return (
    <div  className="row">
      <div className="col-3">
        <ListGroup>
          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/admin/allusers"
            action
          >
            All Users
          </Link>

          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/admin/alldarshan"
            action
          >
            All Darshan
          </Link>

          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/admin/allpooja"
            action
          >
            All Pooja
          </Link>

          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/admin/allarti"
            action
          >
            All Arti
          </Link>

          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/admin/allaccomodation"
            action
          >
            All Accomodation
          </Link>
        </ListGroup>
      </div>
      <div className="col-9">
        <Outlet />
      </div>
    </div>
  );
};

export default Content;
