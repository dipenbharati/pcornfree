
import React from 'react'

const ListUserSession = () => {

    const dummyData = [
        {
            "id": 1,
            "firstName": "java",
            "lastName": "guides",
            "email": "java@gmail.com"
        },
        {
            "id": 2,
            "firstName": "node",
            "lastName": "js",
            "email": "node@gmail.com"
        }
    ]
  return (
    <div className='container'>
        
        <h2 className='text-center'> Current Sessions </h2>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Session Name</th>
                    <th>Start Time</th>
                    <th>End Time</th>
                    <th>Remaining Time</th>
                </tr>
            </thead>
            <tbody>
                {
                    dummyData.map(session =>
                        <tr key={session.id}>
                                <td>{session.firstName}</td>
                                <td>{session.lastName}</td>
                                <td>{session.email}</td>
                                <td>{session.email}</td>
                        </tr>)
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListUserSession