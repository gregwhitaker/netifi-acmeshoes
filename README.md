# netifi-acmeshoes
Simple store application that composes calls to backend product information services and displays a product page.

This example application shows you how to build microservice architectures using [Netifi](https://www.netifi.com) and [RSocket](http://rsocket.io).

## Project Structure
The example contains a number of backend microservices that are called by the [store-app](store-app) to retrieve product information necessary to display a Product Display Page (PDP).

The APIs for the backend services are defined as Protobuf contracts in the `-idl` projects. These projects, when built, generate service stubs and clients that are imported and used by
the service and store-app projects.

## License
Copyright 2019 Greg Whitaker

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.