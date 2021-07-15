import React from "react";
import "./Project.css";
import type ProjectData from "../../data/ProjectData";
import Links from "../Links/Links";
import TechContainer from "../TechContainer/TechContainer";
import { faArchive, faCog, faTools } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

type Props = {
  project: ProjectData;
};

const getStatusIcon = (status: string) => {
  switch (status) {
    case "ACTIVE":
      return <FontAwesomeIcon icon={faTools} />;
    case "PRODUCTION":
      return <FontAwesomeIcon icon={faCog} />;
    case "ARCHIVED":
      return <FontAwesomeIcon icon={faArchive} />;
    default:
      return <></>;
  }
};

const Project = (props: Props) => {
  var { project } = props;
  return (
    <div className="col-lg-4 col-md-6 mt-3 mb-2">
      <div className="h-100 card">
        <div className="d-flex justify-content-between card-header">
          <div className="header-text"></div>
          <img
            className="project-logo"
            src={project.logo}
            alt={project.title}
          />
          <div className="header-text">
            <p className="text-end">{project.year}</p>
            <p className="text-end">{project.type}</p>
            <p className="text-end">{getStatusIcon(project.status)}</p>
          </div>
        </div>
        <h5 className="card-title pt-1">{project.title}</h5>
        <div className="card-body">
          <div className="card-text text-start">{project.description}</div>
          <Links links={project.links}></Links>
        </div>
        <div className="h-100 card-footer ps-0">
          <TechContainer tech={project.tech}></TechContainer>
        </div>
      </div>
    </div>
  );
};

export default Project;
