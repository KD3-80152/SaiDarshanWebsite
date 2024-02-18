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
            to="/admin/user/all"
            action
          >
            All Users
          </Link>

          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/admin/darshan/all"
            action
          >
            All Darshan
          </Link>

          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/admin/pooja/all"
            action
          >
            All Pooja
          </Link>

          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/admin/aarti/all"
            action
          >
            All Arti
          </Link>

          <Link
            className="list-group-item list-group-item-action"
            tag="a"
            to="/admin/accommodation/all"
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
