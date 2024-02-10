 ________________________________________________
|                        TravelPackage           |
|________________________________________________|
| - name: String                                  |
| - passengerCapacity: int                        |
| - itinerary: List<Destination>                  |
| - passengers: List<Passenger>                   |
|________________________________________________|
| + addPassenger(passenger: Passenger): void      |
| + printItinerary(): void                        |
| + printPassengerList(): void                    |
|________________________________________________|
                     /\
                     |
                     |
         ____________|____________
        |                         |
        |                      Destination
        |_________________________|
        | - name: String           |
        | - activities: List<Activity> |
        |_________________________|
        | + addActivity(activity: Activity): void |
        |_________________________|
                      /\
                      |
                      |
         _____________|_____________
        |                          |
        |                       Activity
        |__________________________|
        | - name: String           |
        | - description: String    |
        | - cost: double           |
        | - capacity: int          |
        | - destination: Destination |
        |__________________________|
                    /\
                    |
                    |
         ___________|______________
        |                          |
        |                       Passenger
        |__________________________|
        | - name: String           |
        | - passengerNumber: int   |
        | - passengerType: PassengerType |
        |__________________________|
         ______/      |      \________
        |              |               |
        |       StandardPassenger    GoldPassenger
        |____________________________|
        |                            |
        | - balance: double          |
        |____________________________|
                     |
                     |
               PremiumPassenger
               _______________
              |                 |
              |_________________|
