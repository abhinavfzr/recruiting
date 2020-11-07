
Build a backend service that handles a (very simple) recruiting process. The process
requires two types of objects: job offers and applications from candidates. minimum
required fields for the objects are:
Offer:
jobTitle (unique)
startDate
numberOfApplications
Application:
related offer
candidate email (unique per Offer)
resume text
applicationStatus (APPLIED, INVITED, REJECTED, HIRED)
Not all of the fields have to be persisted. These are the fields that must be returned by the
API. You may add fields where necessary.
Use cases
-user has to be able to create a job offer and read a single and list all offers.
-candidate has to be able to apply for an offer.
-user has to be able to read one and list all applications per offer.
Technical requirements
The service must run standalone and must not require any third party software to be
installed. the service must communicate Json over http (REST). return proper status codes
for the most common problems.
Things we are looking for
- clean code
- Java 8
- Rest API standard
- use of any framework
- structure of the project
- basic Junit test
Do not focus on additional aspects like authentication, authorization or anything from
front-end or other interacting services. If something is not clear add reasonable
assumptions & go with them

