import React from 'react';
import './styles.css'
import {ReactComponent as Logo} from '../../asserts/logo.svg'
const Header= () => (
    <header className="main-header">
        <Logo/>
        <div>
            <span className="logo-text-1"> Big Game</span>
            <span className="logo-text-2"> Survey</span>
        </div>
    </header>
);
export default Header;