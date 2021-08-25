import React from 'react'
import { Link } from 'react-router-dom'
import './TeamTile.scss'

export const TeamTile = ({teamName}) => {
    return(
    <div className="teamTile">
    <h1>
            <Link to={`/teams/${teamName}`}>
                {teamName}
            </Link>
        </h1>
</div>)
}
