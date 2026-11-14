# LLD Delivery Framework

1. Requirements
2. Entities
3. Class Design
4. Implementation
5. Extensibility


## Requirements

1. Primary capabilites
2. Error Handling
3. Boundary / Out of scope

### Primary Capabilities

1. Multiple sizes of locker (S, M, L)
2. OTP code sent over sms or email
3. Item delivery & return


### Error Handling
1. Item size & locker size mismatch
2. Invalid OTP code / OTP Expiry
3. No available locker for that size

### Out of Scope
1. Item return
2. Item reached from hub to amazon locker



## Write Clear requirements

1. Delivery partner reaches the amazon locker
2. Snan the package on basis of that
    - find best suitable compartment for the package
        - If no available locker then throw error
3. put the item in the locker, otp will be generated and sent to customer
    - Compartment will be marked as filled
4. Customer will reach locker, entered the shared OTP, take out the package
    Compartment will be marked as empty


Out of scope
1. Customer will choose the nearest locker to him.
2. Item return by customer by amazon locker


## Entites
- AmazonLocker
- Compartment
- Access Token
- Package

- Package
- entities.User / Driver


## Classes

class AmazonLocker:
- List<Compartments> compartments
- Map<String, Compartment> accessCodeMap;

+ deliverPackage(Package package): void
+ collectPackage(Long packageID, String accessToken): void
+ getAvailableLocker(size): Compartment
+ generateToken(): String
+ notifyUser(userID, packageID, accessToken)



class Compartment
- size: Enum: SMALL, MEDIUM, LARGE
- isVacant: Boolean

+ getSize(): Size
+ getIsVacant: Boolean
+ markFilled: void
+ markVacant: void



class Package
- packageId: Long
- QR: String
- size: SIZE (enum)
- userID: Long
- accessCode :String

+ getPackageSize: Size
+ getUserID: userID
