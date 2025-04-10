Below is an example “Branch” module refactored into a more hexagonal layout.
We’ve separated:

• Inbound adapter (REST controller)  
• Outbound adapter (JPA repository + spec)  
• Application layer (use cases, mapper, DTO/request classes)  
• Domain (entity)

All package names have been updated accordingly.

