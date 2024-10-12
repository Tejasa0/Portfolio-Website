import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Projects = () => {
  const [projects, setProjects] = useState([]);

  useEffect(() => {
    const fetchProjects = async () => {
      try {
        const response = await axios.get('http://localhost:8081/portfolio/projects'); // Update API URL
        setProjects(response.data);
      } catch (error) {
        console.error('Error fetching projects:', error);
      }
    };

    fetchProjects();
  }, []);

  return (
    <section className="projects">
      <h2>Projects</h2>
      {projects.length > 0 ? (
        projects.map(project => (
          <div key={project.id} className="project">
            <h3>{project.name}</h3>
            <p>{project.description}</p>
            <a href={project.url} target="_blank" rel="noopener noreferrer">View Project</a>
          </div>
        ))
      ) : (
        <p>No projects available</p>
      )}
    </section>
  );
};

export default Projects;
