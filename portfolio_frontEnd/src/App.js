import React from 'react';
import About from './components/About';
import Skills from './components/Skills';
import ProjectList from './components/ProjectList';
import Contact from './components/Contact';
import './App.css';


const App = () => {
  return (
    <div className="app">
      <h1>Tejas Patil - Software Engineer</h1> {/* Update with your name and title */}
      <About />
      <ProjectList />
      <Skills />
      <Contact />
    </div>
  );
};

export default App;
